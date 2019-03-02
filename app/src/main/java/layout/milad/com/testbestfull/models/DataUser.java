package layout.milad.com.testbestfull.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class DataUser {

    @SerializedName("page")
    private int page;
    @SerializedName("data")
    private List<User> getUser = new ArrayList<>();

    public DataUser() {
    }

    public DataUser(int page, List<User> getUser) {
        this.page = page;
        this.getUser = getUser;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<User> getGetUser() {
        return getUser;
    }

    public void setGetUser(List<User> getUser) {
        this.getUser = getUser;
    }
}
