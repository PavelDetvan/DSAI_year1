def generate_primes(end):
    primes = []
    for i in range(2,end):
        prime = True
        for number in range(2,i):
            if(i%number==0 and number!=i):
                prime = False
        if(prime==True):
            primes.append(i)

    
    return primes


print(generate_primes(100))
