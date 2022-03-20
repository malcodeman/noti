import React from "react";
import renderer from "react-test-renderer";

import Button from "./Button";

test("Button snapshot", () => {
  const component = renderer.create(<Button>Test</Button>);
  const tree = component.toJSON();
  expect(tree).toMatchSnapshot();
});
