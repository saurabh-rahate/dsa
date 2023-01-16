const fib = (n, memo = {}) => {
    if (memo[n]) return memo[n];
    if (n <= 2) return 1;
    let result = fib(n - 1, memo) + fib(n - 2, memo);
    memo[n] = result;
    return result
}

// for(let i =40;i<=50;i++) {
//     console.log(fib(i));
// }

const grid = (m, n, memo = {}) => {
    const key = m + '_' + n;
    if (memo[key]) return memo[key];
    if (m === 0 || n === 0) return 0;
    if (m === 1 && n === 1) return 1;

    const result = grid(m - 1, n, memo) + grid(m, n - 1, memo);
    memo[key] = result;
    return result;
}

// console.log(grid(18, 18));

const canSum = (targetSum, numbers, memo = {}) => {
    if(targetSum in memo) return memo[targetSum];
    if (targetSum === 0) return true;
    if(targetSum < 0 ) return false;

    for (let number of numbers) {
        const remainder = targetSum - number;
        if (canSum(remainder, numbers, memo)) {
            memo[targetSum] = true;
            return true;
        }
    }
    memo[targetSum] = false;
    return false;
}
//
// console.log(canSum(7, [2, 3]));
// console.log(canSum(7, [5, 3, 4, 7]));
// console.log(canSum(7, [2, 4]));
// console.log(canSum(8, [2, 3, 5]));
// console.log(canSum(300, [7, 14]));



const howSum = (targetSum, numbers, memo = {}) => {
    if(targetSum in memo) return memo[targetSum];
    if (targetSum === 0) return [];
    if(targetSum < 0 ) return null;

    for (let number of numbers) {
        const remainder = targetSum - number;
        const result = howSum(remainder, numbers, memo);
        if (result !== null) {
            memo[targetSum] = [ ...result, number];
            return memo[targetSum];
        }
    }
    memo[targetSum] = null;
    return null;
}

console.log(howSum(7, [2, 3]));
console.log(howSum(7, [5, 3, 4, 7]));
console.log(howSum(7, [2, 4]));
console.log(howSum(8, [2, 3, 5]));
console.log(howSum(300, [7, 14]));
