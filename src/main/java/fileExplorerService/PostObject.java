package fileExplorerService;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostObject{

    @JsonProperty("path")
    private String path;

    public void PostObject() {

    }

    public String getPath() {
        return this.path;
    }

}
