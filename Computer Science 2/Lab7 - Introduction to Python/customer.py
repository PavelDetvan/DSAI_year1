class Customer:
    def __init__(self, name, prod_list):
        self.name = name
        self.prod_list = prod_list

    def add(self, name, amount):
        self.prod_list.append((name, amount))
    
    def products(self):
        return self.prod_list

    def expensive_products(self, price):
        results = []
        for element in self.prod_list:
            if element[1]>price:
                results.append(element[0])

        if len(results)==1:
            return ''.join(results)
        else:
            return results

test = Customer("test", prod_list=[])
test.add("carrots", 10)
test.add("banana", 5)

test.add("bread", 2)
print(test.expensive_products(4))
print(test.products())
