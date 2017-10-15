package fileExplorerService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;

@Controller
@RequestMapping("/hello-world")
public class FileExplorerServiceController {

    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody String sayHello(@RequestParam(value="path") String path) {

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
