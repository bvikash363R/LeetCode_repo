class Trinonacci:
    def tribonacci_help(self, n : int, memo : list) -> int:
    
     if n == 0:
        return 0
     if n == 1 or n == 2:
        return 1
     if memo[n] != -1:
        return memo[n]
    
     memo[n] = self.tribonacci_help(n-1,memo)+ self.tribonacci_help(n-2, memo)+ self.tribonacci_help(n-3,memo)

     return memo[n]


    def tribonacci(self, n : int) -> int:
      
      if n == 0:
            return 0
      if n == 1 or n == 2:
            return 1
    
      memo = [-1]*(n+1)
      return self.tribonacci_help(n, memo)




sol = Trinonacci()
print(sol.tribonacci(25))
    




