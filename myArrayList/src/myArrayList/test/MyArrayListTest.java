package myArrayList.test;

import java.util.Arrays;
import myArrayList.MyArrayList;
import myArrayList.util.Results;
/**
* MyArrayListTest program helps in testing all functions of myArrayList
*
* @author  Gaurang Dhake
* @version 1.8
* @since   06/14/18 
*/
public class MyArrayListTest {
	
	public MyArrayListTest() {}
	/**
	   * This is method which calls other methods to test functionality of myArrayList
	   * @param myArrayListObj instance of myArrayList from Driver class
	   * @param resultObj instance of Results to store test result strings
	   * @return None Since return type is void
	   */
	public void testMe(MyArrayList myArrayListObj, Results resultObj) {
		resultObj.storeNewResult(elementsInRange(myArrayListObj,resultObj));
		resultObj.storeNewResult(arraySortedAfterInsert(myArrayListObj,resultObj));
		resultObj.storeNewResult(arraySortedAfterRemove(myArrayListObj,resultObj));
		resultObj.storeNewResult(elementInArray(myArrayListObj,resultObj));
		resultObj.storeNewResult(arrayUnderFlow(myArrayListObj,resultObj));
		resultObj.storeNewResult(arrayOverFlow(myArrayListObj,resultObj));
		resultObj.storeNewResult(correctSumOfElements(myArrayListObj,resultObj));
		resultObj.storeNewResult(correctSumOfElementsAfterRemove(myArrayListObj,resultObj));
		resultObj.storeNewResult(removeElementFromEmptyArray(myArrayListObj,resultObj)); 
		resultObj.storeNewResult(toStringCheck(myArrayListObj,resultObj));
	}
	
	/**
	   * This is method which makes sure elements are in the range
	   * @param myArrayListObj instance of myArrayList from Driver class
	   * @param resultObj instance of Results to store test result strings
	   * @return String returns whether test numbers are in range is passed or failed
	   */
	public String elementsInRange(MyArrayList myArrayListObj, Results resultObj) {
		myArrayListObj = new MyArrayList();
		myArrayListObj.insertSorted(10);
		myArrayListObj.insertSorted(9999);
		myArrayListObj.insertSorted(-10);
		myArrayListObj.insertSorted(12000);
		myArrayListObj.insertSorted(555);
		if(myArrayListObj.size() == 3) {
			return "\n\nTest 1: test numbers are in range passed!!";
		}
		else {
			return "\n\nTest 1: test numbers are in range failed!!";
		}
		
	}

	/**
	   * This is method which makes sure elements are inserted and are sorted
	   * @param myArrayListObj instance of myArrayList from Driver class
	   * @param resultObj instance of Results to store test result strings
	   * @return String returns whether test numbers are in range is passed or failed
	   */
	public String arraySortedAfterInsert(MyArrayList myArrayListObj, Results resultObj) {
		myArrayListObj = new MyArrayList();
		int tempArr[] = {1,10,555,1000,9999};
		myArrayListObj.insertSorted(10);
		myArrayListObj.insertSorted(9999);
		myArrayListObj.insertSorted(1);
		myArrayListObj.insertSorted(1000);
		myArrayListObj.insertSorted(555);
		for(int i=0;i<5;i++) {
			if(tempArr[i] != myArrayListObj.getArray()[i]) {
				return "Test 2: test array sorted after insert failed!!";
			}
		}
		return "Test 2: test array sorted after insert passed!!";
	}

	/**
	   * This is method which makes sure elements are removed and are sorted
	   * @param myArrayListObj instance of myArrayList from Driver class
	   * @param resultObj instance of Results to store test result strings
	   * @return String returns whether test numbers are in range is passed or failed
	   */
	public String arraySortedAfterRemove(MyArrayList myArrayListObj, Results resultObj) {
		myArrayListObj = new MyArrayList();
		int tempArr[] = {1,10,555,9999};
		myArrayListObj.insertSorted(10);
		myArrayListObj.insertSorted(9999);
		myArrayListObj.insertSorted(1);
		myArrayListObj.insertSorted(1000);
		myArrayListObj.insertSorted(555);
		myArrayListObj.removeValue(1000); 
		for(int i=0;i<4;i++) {
			if(tempArr[i] != myArrayListObj.getArray()[i]) {
				return "Test 3: test array sorted after remove failed!!";
			}
		}
		return "Test 3: test array sorted after remove passed!!";
	}

	/**
	   * This is method search for required element and returns index
	   * @param myArrayListObj instance of myArrayList from Driver class
	   * @param resultObj instance of Results to store test result strings
	   * @return String returns whether test numbers are in range is passed or failed
	   */
	public String elementInArray(MyArrayList myArrayListObj, Results resultObj) {
		myArrayListObj = new MyArrayList();
		myArrayListObj.insertSorted(77);
		myArrayListObj.insertSorted(56);
		myArrayListObj.insertSorted(9561);
		myArrayListObj.insertSorted(852);
		myArrayListObj.insertSorted(999);
		
		if(myArrayListObj.indexOf(9561) == 4) {
			return "Test 4: test element present in array passed!!";
		}
		
		return "Test 4: test element present in array failed!!";
	}

	/**
	   * This is method checks array works fine when under-flow
	   * @param myArrayListObj instance of myArrayList from Driver class
	   * @param resultObj instance of Results to store test result strings
	   * @return String returns whether test numbers are in range is passed or failed
	   */	
	public String arrayUnderFlow(MyArrayList myArrayListObj, Results resultObj) {
		myArrayListObj = new MyArrayList();
		for(int i=0;i<48;i++) {
			myArrayListObj.insertSorted(i*10);
		}
		if(myArrayListObj.getArray().length == 50) {
			return "Test 5: test array underflow is passed!!";
		}
		return "Test 5: test array underflow is failed!!";
	}

	/**
	   * This is method checks array works fine when over-flow
	   * @param myArrayListObj instance of myArrayList from Driver class
	   * @param resultObj instance of Results to store test result strings
	   * @return String returns whether test numbers are in range is passed or failed
	   */
	public String arrayOverFlow(MyArrayList myArrayListObj, Results resultObj) {
		myArrayListObj = new MyArrayList();
		for(int i=0;i<60;i++) {
			myArrayListObj.insertSorted(i*10);
		}
		if(myArrayListObj.getArray().length == 75) {
			return "Test 6: test array overflow is passed!!";
		}
		return "Test 6: test array overflow is failed!!";
	}

	/**
	   * This is method checks if elements add up correctly after insertion
	   * @param myArrayListObj instance of myArrayList from Driver class
	   * @param resultObj instance of Results to store test result strings
	   * @return String returns whether test numbers are in range is passed or failed
	   */
	public String correctSumOfElements(MyArrayList myArrayListObj, Results resultObj) {
		myArrayListObj = new MyArrayList();
		myArrayListObj.insertSorted(9465);
		myArrayListObj.insertSorted(643);
		myArrayListObj.insertSorted(177);
		myArrayListObj.insertSorted(111);
		myArrayListObj.insertSorted(7816);
		int sum = myArrayListObj.sum();
		if(sum == 18212) {
			return "Test 7: test sum of elements after insert passed!!"; 
		}
		else {
			return "Test 7: test sum of elements after insert failed!!";
		}
	}

	/**
	   * This is method checks if elements add up correctly after removal
	   * @param myArrayListObj instance of myArrayList from Driver class
	   * @param resultObj instance of Results to store test result strings
	   * @return String returns whether test numbers are in range is passed or failed
	   */
	public String correctSumOfElementsAfterRemove(MyArrayList myArrayListObj, Results resultObj) {
		myArrayListObj = new MyArrayList();
		myArrayListObj.insertSorted(9465);
		myArrayListObj.insertSorted(643);
		myArrayListObj.insertSorted(177);
		myArrayListObj.insertSorted(111);
		myArrayListObj.insertSorted(7816);
		myArrayListObj.removeValue(111);
		int sum = myArrayListObj.sum();
		if(sum == 18101) {
			return "Test 8: test sum of elements after remove passed!!"; 
		}
		else {
			return "Test 8: test sum of elements after remove failed!!";
		}
	}

	/**
	   * This is method makes sure array remains as it is even after non-member is tried to be removed
	   * @param myArrayListObj instance of myArrayList from Driver class
	   * @param resultObj instance of Results to store test result strings
	   * @return String returns whether test numbers are in range is passed or failed
	   */
	public String removeElementFromEmptyArray(MyArrayList myArrayListObj, Results resultObj) {
		myArrayListObj = new MyArrayList();
		int tempArr[] = new int[50];
		myArrayListObj.removeValue(45);
		if(Arrays.equals(tempArr, myArrayListObj.getArray())) {
			return "Test 9: test remove element from empty array passed!!";
		}
		else {
			return "Test 9: test remove element from empty array failed!!";
		}
	}

	/**
	   * This is method checks to correct toString representation of array
	   * @param myArrayListObj instance of myArrayList from Driver class
	   * @param resultObj instance of Results to store test result strings
	   * @return String returns whether test numbers are in range is passed or failed
	   */
	public String toStringCheck(MyArrayList myArrayListObj, Results resultObj) {
		myArrayListObj = new MyArrayList();
		String exceptedStr = "[ 24 34 65 98 ]";
		myArrayListObj.insertSorted(34);
		myArrayListObj.insertSorted(65);
		myArrayListObj.insertSorted(24);
		myArrayListObj.insertSorted(98);
		if(myArrayListObj.toString().equals(exceptedStr)) {
			return "Test 10: test correct elements in array by toString method passed!!";
		}
		else {
			return "Test 10: test correct elements in array by toString method failed!!";
		}
	}
	
}
