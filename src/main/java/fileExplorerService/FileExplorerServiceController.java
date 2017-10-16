package fileExplorerService;

import com.google.gson.Gson;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.File;

@Controller
@RequestMapping("/file-explorer-service")
public class FileExplorerServiceController {

    @RequestMapping(method=RequestMethod.POST,  consumes =
            {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody String fileServicePost(@RequestBody PostObject pathObj) {
        final Gson gson = new Gson();
        String path = pathObj.getPath();

//        StringBuilder stb = new StringBuilder();


        File folder = Main.getFolder(path);
        FileObj[] fileArray = Main.getFileObjs(new File[] {folder});
        QuickSort qs = new QuickSort();

//            stb.append("sorted by filesize: \n");

        FileObj[] sortedFileArray = fileArray;
        if(fileArray.length > 1){
            sortedFileArray = qs.sortFileObj(fileArray);
        }

        for (int i = 0; i < sortedFileArray.length; i++) {
//                stb.append("File Name: " + sortedFileArray[i].fileName + " File Size: " + sortedFileArray[i].getFileSizeInMB() + "mbs" + " File Extension: " + sortedFileArray[i].fileExtension + "\n");
        }
        return gson.toJson(sortedFileArray);

        //return stb.toString();



    }

    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody String fileServiceGet(@RequestParam(value="path") String path) {

        StringBuilder stb = new StringBuilder();
        if (path != null) {

            File folder = Main.getFolder(path);
            FileObj[] fileArray = Main.getFileObjs(new File[] {folder});
            QuickSort qs = new QuickSort();

            stb.append("sorted by filesize: \n");
            FileObj[] sortedFileArray = qs.sortFileObj(fileArray);

            for (int i = 0; i < sortedFileArray.length; i++) {
                stb.append("File Name: " + sortedFileArray[i].fileName + " File Size: " + sortedFileArray[i].getFileSizeInMB() + "mbs" + " File Extension: " + sortedFileArray[i].fileExtension + "\n");
            }

        } else {
            stb.append("Usage: Put in file path for recursive search for the largest file in the path\n");
        }

        return stb.toString();
    }


}
