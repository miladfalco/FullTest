package layout.milad.com.testbestfull.activity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

import layout.milad.com.testbestfull.R;
import layout.milad.com.testbestfull.adapter.AdapterClass;
import layout.milad.com.testbestfull.models.SongObject;
import layout.milad.com.testbestfull.sevice.MusicService;

public class ListOfSongsActivity extends AppCompatActivity {

    private ListView listView;
    private Button btnPlayStop;
    private TextView txtSongName;
    private CardView cardView;
    private ArrayList<SongObject> listOfContents;
    private AdapterClass adapter;
    private String path;
    public static String absolutePath, songName;
    public static boolean playing = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_songs);
        if (Build.VERSION.SDK_INT >= 23) {
            checkPermission();
        } else {
            initViews();
        }
    }

    private void initViews() {
        btnPlayStop = findViewById(R.id.btnPlayStop);
        txtSongName = findViewById(R.id.txtSongName);
        cardView = findViewById(R.id.cardView);
        listView = findViewById(R.id.listView);
        listOfContents = new ArrayList<>();

        if (playing) {
            txtSongName.setText(songName);
            cardView.setVisibility(View.VISIBLE);
            btnPlayStop.setText("Stop");
        }

        path = Environment.getExternalStorageDirectory().getAbsolutePath();
        initList(path);

        adapter = new AdapterClass(this, R.layout.list_item, listOfContents);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                cardView.setVisibility(View.VISIBLE);

                if (playing) {
                    Intent i = new Intent(ListOfSongsActivity.this, MusicService.class);
                    stopService(i);
                }

                playing = true;

                SongObject sdOb = listOfContents.get(position);
                absolutePath = sdOb.getAbsolutePath();

                Intent start = new Intent(ListOfSongsActivity.this, MusicService.class);
                startService(start);

                songName = listOfContents.get(position).getFileName();
                txtSongName.setText(songName);
                btnPlayStop.setText("Stop");

            }
        });

        btnPlayStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (playing) {

                    playing = false;
                    btnPlayStop.setText("Play");
                    Intent i = new Intent(ListOfSongsActivity.this, MusicService.class);
                    stopService(i);
                } else if (!playing) {

                    playing = true;
                    btnPlayStop.setText("Stop");
                    Intent i = new Intent(ListOfSongsActivity.this, MusicService.class);
                    startService(i);
                }
            }
        });
    }

    private void initList(String path) {
        try {
            File file = new File(path);
            File[] filesArray = file.listFiles();
            String fileName;
            for (File file1 : filesArray) {
                if (file1.isDirectory()) {
                    initList(file1.getAbsolutePath());
                } else {
                    fileName = file1.getName();
                    if ((fileName.endsWith(".mp3")) || (fileName.endsWith(".mp4"))) {
                        listOfContents.add(new SongObject(file1.getName(), file1.getAbsolutePath()));
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void checkPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) ==
                PackageManager.PERMISSION_GRANTED) {
            initViews();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    initViews();
                } else {
                    if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
                        finish();
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(this);
                        builder.setMessage("شما درخواست دسترسی های ضروری را رد کرده اید.برنامه برای اجرانیاز به دسترسی ها مورد نظر دارد")
                                .setPositiveButton("Grant", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int id) {
                                        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                                                Uri.fromParts("package", getPackageName(), null));
                                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                        startActivity(intent);
                                    }
                                })
                                .setNegativeButton("Don't", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        finish();
                                    }
                                });
                        builder.setCancelable(false);
                        builder.create().show();
                    }
                }
        }
    }

}
