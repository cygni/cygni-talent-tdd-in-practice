export function calculate(input: string): string {
  if (input.includes("+")) {
    const [first, second] = input.split("+");
    return (Number(first) + Number(second)).toString();
  } else if (input.includes("-")) {
    const [first, second] = input.split("-");
    return (Number(first) - Number(second)).toString();
  }
  return "";
}
