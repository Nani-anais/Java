public class AddBinaryIntegers {
    //two arrays A and B and int n holds the array length
    public static int[] addBinaryIntegers(int[] A, int[] B, int n)
    {
        //initialize the result array C with n+1 elements, all set to 0
        int[] C = new int[n + 1];

        //initialize carry to 0
        int carry = 0;

        //iterate from the least significant bit (rightmost) to the most significant
        for (int i = n - 1; i >= 0; i--)
        {
            //preform the bit wise addition
            int sum = A[i] + B[i] + carry;

            //compute the current bit in the result (0 or 1)
            C[i + 1] = sum % 2;

            //compute the carry for the next bit
            carry = sum / 2;
        }
        //if there is a carry after the most significant bit addition, set it to the result.
        C[0] = carry;

        return C;
    }
    public static void main(String[] args) {
        int[] A = {1, 1, 1, 1}; //15 in decimal
        int[] B = {1, 1, 0, 0}; //12 in decimal
        int n = 4; //array length
        int[] result = addBinaryIntegers(A, B, n);

        for (int bit: result)
        {
            System.out.print(bit + " ");
        }
        //output should be 11011 which is 27 in decimal
    }
}
