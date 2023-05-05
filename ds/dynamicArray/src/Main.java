public class Main {
    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.append(12);
        dynamicArray.append(11);
        dynamicArray.append(13);
        dynamicArray.append(14);
        System.out.println(dynamicArray.toString());
        System.out.println(dynamicArray.getItem(5));
        System.out.println(dynamicArray.getItem(2));
        System.out.println(dynamicArray.len());
    }
}