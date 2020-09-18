#学习笔记

##基本概念
1. java中Map是键值（key-value）映射表的数据结构，作用就是能高效通过key快速查找value元素；
2. Map<K, V>是一种键-值映射表，当我们调用put(K key, V value)方法时，就把key和value做了映射并放入Map。当我们调用V get(K key)时，就可以通过key获取到对应的value。如果key不存在，则返回null。和List类似，Map也是一个接口，最常用的实现类是HashMap；
3. 如果只是想查询某个key是否存在，可以调用boolean containsKey(K key)方法；
4. 对于同一个key重复调用put()方法(重复放入key-value)并不会有任何问题，但是一个key只能关联一个value，如果放入的key已经存在，原来关联的value对象会被覆盖，put方法会返回被覆盖的旧的value，否则返回null；
5. 在一个HashMap中，虽然key不能重复，但是value是可以重复的；

##基本操作
###遍历
1. 遍历Map，可以使用for each 循环遍历Map实例的keySet()方法返回的Set集合，它包含不重复的key的集合；
2. 同时遍历key和value，可以使用for each 循环遍历Map对象的entrySet()集合，它包含每一个key-value映射;

###顺序
1. HashMap存储的是key-value的映射关系，不保证顺序。在遍历的时候，遍历的顺序既不一定是put()时放入的key的顺序，也不一定是key的排序顺序。使用Map时，任何依赖顺序的逻辑都是不可靠的；
2. TreeMap在内部会对key进行排序