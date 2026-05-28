package utils.verifications;

public class Verifications {
    public static void IndexOutOfBoundsVerification(int index, int size) {
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        };
    }
}
