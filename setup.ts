const notAllowedFunction = () => {
  console.error("Sorry, this function is not allowed in this assignment.");
};

global.eval = notAllowedFunction;
