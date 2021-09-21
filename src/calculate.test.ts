import { calculate } from "./calculate";
it("should add two numbers", () => {
  expect(calculate("5+5")).toEqual("10");
});

it("should subtract two numbers", () => {
  expect(calculate("10-5")).toEqual("5");
  expect(calculate("5-5")).toEqual("0");
});

it("should multiply two numbers", () => {
  throw Error("Not implemented.");
});

it("should divide two numbers", () => {
  throw Error("Not implemented.");
});

// Write more test cases as you go.
