module.exports = {
  transform: {
    "^.+\\.ts": "ts-jest",
  },
  setupFiles: ["./setup.ts"],
  globals: {
    "ts-jest": {
      diagnostics: {
        ignoreCodes: ["TS151001"],
      },
    },
  },
};
