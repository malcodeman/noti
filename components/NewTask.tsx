import React from "react";
import { View, TextInput, StyleSheet } from "react-native";
import { isEmpty, isNil } from "ramda";

import Button from "../system/Button";

const styles = StyleSheet.create({
  wrapper: {
    paddingHorizontal: 16,
  },
  input: {
    marginBottom: 16,
    fontSize: 16,
  },
});

type Props = {
  onSubmit: (data: { value: string }) => void;
};

function NewTask(props: Props) {
  const { onSubmit } = props;
  const inputEl = React.useRef<TextInput>(null);
  const [value, setValue] = React.useState("");

  function handleOnPress() {
    if (isEmpty(value) && !isNil(inputEl.current)) {
      inputEl.current.focus();
    } else {
      onSubmit({ value });
      setValue("");
    }
  }

  return (
    <View style={styles.wrapper}>
      <TextInput
        placeholder="New task"
        onChangeText={(value) => setValue(value)}
        value={value}
        style={styles.input}
        ref={inputEl}
      />
      <Button onPress={handleOnPress}>Add new task</Button>
    </View>
  );
}

export default NewTask;
