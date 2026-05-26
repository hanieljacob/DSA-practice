class Solution:

    def encode(self, strs: List[str]) -> str:
        encoded_string = ""
        for string in strs:
            string_length = len(string)
            encoded_string += str(string_length) + "#" + string
        return encoded_string
    def decode(self, s: str) -> List[str]:
        decoded_list = []
        size = ""
        index = 0
        while index < len(s):
            char = s[index]
            if char.isdigit():
                size += char
            if char == "#":
                item = s[index+1: index+1+int(size)]
                decoded_list.append(item)
                index += int(size)
                size = ""
            index += 1
        return decoded_list
