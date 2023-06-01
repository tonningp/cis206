def mergeSort(array,leftIndex,rightIndex):
    if leftIndex >= rightIndex:
        print('returning',array[leftIndex])
        return
    # This is the point where the array is divided into two subarrays
    midPoint = (leftIndex+rightIndex) // 2

    # Sort the two halves
    if len(array[leftIndex:midPoint]):
        # The first and second halves of the data set
        print('leftSide','midPoint',midPoint,'first half',array[leftIndex:midPoint+1],'second half',array[midPoint+1:rightIndex+1])
    mergeSort(array,leftIndex,midPoint)
    if len(array[leftIndex:midPoint]):
        # The first and second halves of the data set
        print('rightSide','midPoint',midPoint,'first half',array[leftIndex:midPoint+1],'second half',array[midPoint+1:rightIndex+1])
    mergeSort(array,midPoint+1,rightIndex)

    merge(array,leftIndex,rightIndex,midPoint)
    print('after merge',array)

def merge(array, leftIndex, rightIndex, middle):
    # Make copies of both arrays we're trying to merge

    # The second parameter is non-inclusive, so we have to increase by 1
    leftCopy = array[leftIndex:middle + 1]
    rightCopy = array[middle+1:rightIndex+1]

    # Initial values for variables that we use to keep
    # track of where we are in each array
    leftCopyIndex = 0
    rightCopyIndex = 0
    sortedIndex = leftIndex

    # Go through both copies until we run out of elements in one
    while leftCopyIndex < len(leftCopy) and rightCopyIndex < len(rightCopy):

        # If our leftCopy has the smaller element, put it in the sorted
        # part and then move forward in leftCopy (by increasing the pointer)
        if leftCopy[leftCopyIndex] <= rightCopy[rightCopyIndex]:
            array[sortedIndex] = leftCopy[leftCopyIndex]
            leftCopyIndex = leftCopyIndex + 1
        # Opposite from above
        else:
            array[sortedIndex] = rightCopy[rightCopyIndex]
            rightCopyIndex = rightCopyIndex + 1

        # Regardless of where we got our element from
        # move forward in the sorted part
        sortedIndex = sortedIndex + 1

    # We ran out of elements either in leftCopy or rightCopy
    # so we will go through the remaining elements and add them
    while leftCopyIndex < len(leftCopy):
        array[sortedIndex] = leftCopy[leftCopyIndex]
        leftCopyIndex = leftCopyIndex + 1
        sortedIndex = sortedIndex + 1

    while rightCopyIndex < len(rightCopy):
        array[sortedIndex] = rightCopy[rightCopyIndex]
        rightCopyIndex = rightCopyIndex + 1
        sortedIndex = sortedIndex + 1    

array = [6, 5, 12, 10, 9, 21,4,20,6,20,3,22]
print('begin',array)
mergeSort(array,0,len(array)-1)
print('end',array)