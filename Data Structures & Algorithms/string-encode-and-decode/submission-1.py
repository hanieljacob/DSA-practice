class Solution:

    def encode(self, strs: List[str]) -> str:
        result = ""
        for string in strs:
            result = result + str(len(string)) + "#" + string
        return result
    def decode(self, s: str) -> List[str]:
        index, curr_num, result = 0, "", []
        while index < len(s):
            if ord(s[index]) >= ord('0') and ord(s[index]) <= ord('9'):
                curr_num += s[index]
                index += 1
            else:
                num = int(curr_num)
                curr_num = ""
                result.append(s[index+1:index+1+num])
                index += 1+num
        return result