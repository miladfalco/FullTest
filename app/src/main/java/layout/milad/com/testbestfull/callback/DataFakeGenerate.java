package layout.milad.com.testbestfull.callback;

import android.content.Context;
import android.support.v4.content.res.ResourcesCompat;

import java.util.ArrayList;
import java.util.List;

import layout.milad.com.testbestfull.R;
import layout.milad.com.testbestfull.models.Cloth;

public class DataFakeGenerate {

    public static List<Cloth> getClothes(Context context) {

        List<Cloth> cloths = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Cloth cloth = new Cloth();
            cloth.setId(i);
            cloth.setTitle("سرویس های جدید تصویر");
            cloth.setViewCount(700);
            switch (i) {
                case 1:
                    cloth.setImage(ResourcesCompat.getDrawable(context.getResources(), R.drawable.pic1_clothes, null));
                    break;
                case 2:
                    cloth.setImage(ResourcesCompat.getDrawable(context.getResources(), R.drawable.pic2__clothes, null));
                    break;
                case 3:
                    cloth.setImage(ResourcesCompat.getDrawable(context.getResources(), R.drawable.pic3_clothes, null));
                    break;
                case 4:
                    cloth.setImage(ResourcesCompat.getDrawable(context.getResources(), R.drawable.pic4_clothes, null));
                    break;
                case 5:
                    cloth.setImage(ResourcesCompat.getDrawable(context.getResources(), R.drawable.pic5_clothes, null));
                    break;
                case 6:
                    cloth.setImage(ResourcesCompat.getDrawable(context.getResources(), R.drawable.pic6_clothes, null));
                    break;
                case 7:
                    cloth.setImage(ResourcesCompat.getDrawable(context.getResources(), R.drawable.pic7_clothes, null));
                    break;
                case 8:
                    cloth.setImage(ResourcesCompat.getDrawable(context.getResources(), R.drawable.pic8_clothes, null));
                    break;
            }
            cloths.add(cloth);
        }
        return cloths;
    }
}
