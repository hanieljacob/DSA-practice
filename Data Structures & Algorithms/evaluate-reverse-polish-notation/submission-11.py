class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        for token in tokens:
            if token == '+':
                stack.append(stack.pop() + stack.pop())
            elif token == '-':
                element1 = stack.pop()
                element2 = stack.pop()
                stack.append(element2 - element1)
            elif token == '*':
                stack.append(stack.pop() * stack.pop())
            elif token == '/':
                element1 = stack.pop()
                element2 = stack.pop()
                stack.append(int(element2/element1))
            else:
                stack.append(int(token))
            print(stack)
        return int(stack[0])