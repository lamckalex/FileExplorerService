package fileExplorerService;

public class QuickSort {
	
	FileObj[] fileObjs = null;
	
	public void QuickSort(){
		
	}
	
	public FileObj[] sortFileObj(FileObj[] fileObjs){
		this.fileObjs = fileObjs;
		quickSort(0, this.fileObjs.length -1);
		
		return this.fileObjs;
	}
	
	private void quickSort(int low, int high){
		int i = low;
		int j = high;
		
		FileObj pivot = this.fileObjs[low + (high-low)/2];
		
		
		while ( i <= j){
			while(this.fileObjs[i].fileSize < pivot.fileSize){
				i++;
			}
			
			while(this.fileObjs[j].fileSize  > pivot.fileSize){
				j--;
			}
			
			if( i <= j){
				exchange(i,j);
				i++;
				j--;
			}
		}
		
		if( low < j){
			quickSort(low, j);
		}
		
		if(i < high){
			quickSort(i,high);
		}
	}

	private void exchange(int i, int j){
		FileObj tempFileObj = this.fileObjs[i];
		
		this.fileObjs[i] = this.fileObjs[j];
		this.fileObjs[j] =  tempFileObj;
		
	}
	
}


