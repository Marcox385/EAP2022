public class MyChainingHashMapTest {

	public static void main(String[] args) {
		CarPlate cp1 = new CarPlate("XPC9361");
		CarPlate cp2 = new CarPlate("AAA0000");
		CarPlate cp3 = new CarPlate("AAA0001");
		CarPlate cp4 = new CarPlate("AAA0010");
		CarPlate cp5 = new CarPlate("ZZZ9999");
		CarPlate cp6 = new CarPlate("JKL1234");
		CarPlate cp7 = new CarPlate("PQR7890");
		CarPlate cp8 = new CarPlate("XPC9362");
		CarPlate cp9 = new CarPlate("XPC9363");
		CarPlate cp10 = new CarPlate("XPC9367");
		
		MyChainingHashMap <CarPlate, String> map = new MyChainingHashMap<>();
		
		map.put(cp1, "car 1");
		map.put(cp2, "car 2");
		map.put(cp3, "car 3");
		map.put(cp4, "car 4");
		map.put(cp5, "car 5");
		map.put(cp6, "car 6");
		map.put(cp7, "car 7");
		map.put(cp8, "car 8");
		map.put(cp9, "car 9");
		map.put(cp10, "car 10");
		
		System.out.println(map + "\n");
		
		
		map.put(cp3, "car 53");
		map.put(cp6, "car 56");
		map.put(cp6, "car 76");
		map.put(cp9, "car 59");
		map.put(cp9, "car 79");
		map.put(cp9, "car 99");
		
		System.out.println(map + "\n");
		
		map.remove(cp2);
		map.remove(cp6);
		map.remove(cp7);
		map.remove(cp1);
		
		System.out.println(map + "\n");
		
		
		System.out.println(cp3 + " -> " + map.get(cp3));
		System.out.println(cp4 + " -> " + map.get(cp4));
		System.out.println(cp9 + " -> " + map.get(cp9));
		System.out.println(cp1 + " -> " + map.get(cp1));
	} 
}