package myArrayList;

/**
* MyArrayList class implements user-defined arraylist functionity  
*
* @author  Gaurang Dhake
* @version 1.8
* @since   06/14/18 
*/
public class MyArrayList {

	private int array[]; // Array for maintaining values
	private int arrayTemp[]; // Temporary array while resizing array
	private int initSize; // initial size of array
	private int tail; // Maintaining last element in the array
	 
	/**
	   * This is default constructor to initialize array to default values 
	   * @param None Since it sets values to default
	   * @return MyArrayList Object 
	   */
	public MyArrayList() {
		initSize = 50;
		tail = 0;
		array = new int[initSize];
	}
	/**
	   * This is parameterized constructor to initialize array to default values 
	   * @param inputData Since it sets values to default
	   * @return MyArrayList Object 
	   */	
	public MyArrayList(String inputData) {
		initSize = 50;
		tail = 0;
		array = new int[initSize];
		prepareArraySize(inputData);
		populateMyArrayList(inputData);
	}
	
	/**
	   * This method makes sure array is of correct size as of input data 
	   * @param inputData 
	   * @return MyArrayList Object 
	   */
	public void prepareArraySize(String inputData) {
		String[] inputDataArray = inputData.split("\\r?\\n");
		if((tail == initSize) || (inputDataArray.length > initSize)) {
			arrayTemp = array;
			array = null; 
			int tempInitSize=0;
			while(inputDataArray.length >= tempInitSize) {
				tempInitSize = initSize;
				tempInitSize = (int)(tempInitSize + (tempInitSize*0.5));
				initSize = tempInitSize;
				
			}
			array = new int[initSize];
			myArrayCopy(arrayTemp,0,array,0,arrayTemp.length);
		}
	}
	
	/**
	   * This method helps copy array elements in case of insertion and removal 
	   *  @param arrayTemp Temporary array from where elements are to be copied
	   *  @param tempArrStartIndex starting index of Temporary array
	   *  @param array Original array to where elements are to be copied
	   *  @param origArrStartIndex starting index of original index
	   *  @param totElements total elements to be copied
	   * @return None Since void is return type 
	   */
	
	public void myArrayCopy(int[] arrayTemp, int tempArrStartIndex, int[] array, int origArrStartIndex, int totElements) {
		
		for(int i=0;i<totElements;i++)
			array[origArrStartIndex++] = arrayTemp[tempArrStartIndex++];
	}
	
	/**
	   * This method takes care of range of elements between 0-10000 and inserts elements
	   * @param inputData 
	   * @return None Since return type if void 
	   */
	public void populateMyArrayList(String inputData) {
		String[] inputDataArray = inputData.split("\\r?\\n");
		for(int i=0;i<inputDataArray.length;i++) {
			int ele = Integer.parseInt(inputDataArray[i]);
			if((ele >= 0) && (ele <= 10000)) {
				array[tail++] = ele;
			}
		}
		sortMyArray(array,0,tail);
	}
	/**
	   * This method calls populateMyArrayList(..) for insertion and the sorts all elements
	   * @param newValue
	   * @return None Since return type if void
	   */	
	public void insertSorted(int newValue) {
		prepareArraySize(String.valueOf(newValue));
		populateMyArrayList(String.valueOf(newValue));
		sortMyArray(array,0,tail);
	}
	
	/**
	   * This method removes all occurances of element from array 
	   * @param value
	   * @return None Since return type if void
	   */
	public void removeValue(int value) {
		for(int i=0;i<tail;i++) {
			if(array[i] == value) {
				myArrayCopy(array, i+1, array, i, tail-i);
				array[tail--] = 0;
			}
		}
	}
	
	/**
	   * This method returns index of desired value from array
	   * @param value 
	   * @return int index of element in array
	   */		
	public int indexOf(int value) {
		for(int i=0;i<tail;i++) {
			if(array[i] == value) {
				return i;
			}
		}
		return -1;
	}
	/**
	   * This method gets the size of array
	   * @param None 
	   * @return int returns the size of array
	   */		
	public int size() {
		if(array.length>0) {
			int i=0;
			for(;i<tail;i++);
			return i;
		}
		else {
			return -1;
		}		
	}
	/**
	   * This method gets the sum of elements in the array
	   * @param None 
	   * @return int returns the sum of elements
	   */	
	public int sum() {
		if(array.length>0) {
			int sum=0;
			for(int i=0;i<tail;i++)
				sum += array[i];
			return sum;
		}
		else {
			return 0;
		}		
	}
	
	/**
	   * This method sorts the array as soon as insertion or removal
	   * @param array Original array
	   * @param fromIndex starting index to be sorted
	   * @param toIndex end index of the array
	   * @return None since void is the return type 
	   */	
	public void sortMyArray(int array[], int fromIndex, int toIndex) {
		for(int i=fromIndex;i<toIndex;i++) {
			for(int j=fromIndex;j<toIndex;j++) {
				if(array[i] < array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
	}
	/**
	   * This method sorts the array as soon as insertion or removal
	   * @param None
	   * @return String Pretty representation of elements in the array
	   */
	@Override
	public String toString() {
		String arrayContents = "[ ";
		for(int i=0;i<tail;i++) {
			arrayContents += array[i]+" ";
		}
		arrayContents += "]";
		return arrayContents;
	}
/*
 * Getters and Setters for private data members
 * */
	public int[] getArray() {
		return array;
	}

	public void setArray(int[] array) {
		this.array = array;
	}

	public int[] getArrayTemp() {
		return arrayTemp;
	}

	public void setArrayTemp(int[] arrayTemp) {
		this.arrayTemp = arrayTemp;
	}

	public int getInitSize() {
		return initSize;
	}

	public void setInitSize(int initSize) {
		this.initSize = initSize;
	}

	public int getTail() {
		return tail;
	}

	public void setTail(int tail) {
		this.tail = tail;
	}
	
}
