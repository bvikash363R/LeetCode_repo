class MyHashSet:
    def __init__(self):
        self.size = 1000
        self.buckets = [[] for _ in range(self.size)]

    def hash_function(self, key):
        return key % self.size

    def add(self, key):
        hash_key = self.hash_function(key)
        if key not in self.buckets[hash_key]:
            self.buckets[hash_key].append(key)

    def remove(self, key):
        hash_key = self.hash_function(key)
        if key in self.buckets[hash_key]:
            self.buckets[hash_key].remove(key)

    def contains(self, key):
        hash_key = self.hash_function(key)
        return key in self.buckets[hash_key]


# Example usage:
my_hash_set = MyHashSet()
my_hash_set.add(1)
my_hash_set.add(2)
print(my_hash_set.contains(1))  # Output: True
print(my_hash_set.contains(3))  # Output: False

