import { calculate } from "./calculate";
it("should add two numbers", () => {
  expect(calculate("5+5")).toEqual("10");
});

it("should subtract two numbers", () => {
  expect(calculate("10-5")).toEqual("5");
  expect(calculate("5-5")).toEqual("0");
  expect(calculate("-5")).toEqual("-5");
});

it("should multiply two numbers", () => {
  expect(calculate("-3*5")).toEqual("-15");
  expect(calculate("3*-5")).toEqual("-15");
});

it("should divivde two numbers", () => {
  expect(calculate("15/5")).toEqual("3");
  expect(calculate("15/-5")).toEqual("-3");
});

it("should add more than two numbers", () => {
  expect(calculate("5+5+3")).toEqual("13");
});

it("should multiply more than two numbers", () => {
  expect(calculate("2*3*4")).toEqual("24");
});

it("should divivde more than two numbers", () => {
  expect(calculate("16/2/2")).toEqual("4");
});

it("should caluclate a mix of multiplication and divison", () => {
  expect(calculate("2*4/2")).toEqual("4");
  expect(calculate("5*14/16*8/10")).toEqual("3.5");
});

it("should caluclate a mix of multiplication and subtraction", () => {
  expect(calculate("-10*2")).toEqual("-20");
});

it("should caluclate a mix of multiplication, divison and subtraction", () => {
  expect(calculate("10-5*3")).toEqual("-5");
  expect(calculate("-10*15")).toEqual("-150");
  expect(calculate("16*7/-14+15/10*-2")).toEqual("-11");
});
