
package layout.milad.com.testbestfull.models;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class DataModel {

    @SerializedName("data")
    private Data mData;

    public Data getData() {
        return mData;
    }

    public void setData(Data data) {
        mData = data;
    }

}
