package fileExplorerService;


public class FileObj {
    final long kbytes = 1024;

	String fileName;

	String fileExtension;

	float fileSize;
	
	
	public FileObj(String fileName, float fileSize){
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.fileExtension = this.getFileExtension(fileName);
	}

	private String getFileExtension(String fileName){
		String[] fileNameArray =fileName.split("\\.");

		String fileExtension = fileNameArray[fileNameArray.length - 1];

		return fileExtension;
	}

    public float getFileSizeInMB(){

        // Get length of file in bytes
        float fileSizeInKB = fileSize / this.kbytes;
        float fileSizeInMB = fileSizeInKB / this.kbytes;

        return fileSizeInMB;
    }
}
