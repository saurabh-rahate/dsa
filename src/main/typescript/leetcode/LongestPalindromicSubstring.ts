function getPallindromeSubStringForGivenLength(s: string, n: number) {
    let i = 0, j = n;
    while (i < j && j <= s.length) {
        let a = s.substring(i, j);

        if (isPallindrome(a))
            return a;
        i++;
        j++;
    }
    return null;
}

function isPallindrome(s: string) {
    let i = 0, j = s.length - 1;
    while (i < j) {
        if (s.charAt(i) != s.charAt(j))
            return false;
        i++;
        j--;
    }
    return true;
}

function longestPalindrome(s: string): string {
    if (s.length == 1)
        return s;
    if (s.length == 2) {
        if (s.charAt(0) == s.charAt(1))
            return s;
        else
            return s.substring(0, 1);
    }

    for (let i = s.length; i >= 2; i--) {
        let subString = getPallindromeSubStringForGivenLength(s, i);
        if (subString != null) {
            return subString;
        }
    }
    return s.substring(0, 1);
};