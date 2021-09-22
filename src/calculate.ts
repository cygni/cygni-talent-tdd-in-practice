const binaryOperate = (
  a: number,
  b: number,
  operator: "+" | "-" | "*" | "/"
) => {
  if (operator === "+") {
    return a + b;
  } else if (operator === "-") {
    return a - b;
  } else if (operator === "*") {
    return a * b;
  } else {
    return a / b;
  }
};

const subRegex = /(?<!\*|\/)-/;

const reduceOperator = (numbers: string[], operator: "+" | "-" | "*" | "/") => {
  return numbers.slice(1).reduce((sum: number, curr: string) => {
    return binaryOperate(sum, _calculate(curr), operator);
  }, _calculate(numbers[0]));
};

export const calculate = (input: string): string => {
  return _calculate(input).toString();
};

function _calculate(input: string): number {
  if (input.includes("+")) {
    const numbers = input.split("+");
    return reduceOperator(numbers, "+");
  } else if (input.split(subRegex).length > 1) {
    const numbers = input.split(subRegex);
    return reduceOperator(numbers, "-");
  } else if (input.includes("*")) {
    const numbers = input.split("*");
    return reduceOperator(numbers, "*");
  } else if (input.includes("/")) {
    const numbers = input.split("/");
    return reduceOperator(numbers, "/");
  }
  return Number(input);
}
