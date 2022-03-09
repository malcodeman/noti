import React from "react";
import { StyleSheet, Text, TextInput, View } from "react-native";
import { StatusBar } from "expo-status-bar";
import { map } from "ramda";

import Button from "../components/Button";

const styles = StyleSheet.create({
  container: {
    padding: 16,
    flex: 1,
    backgroundColor: "#fff",
    alignItems: "center",
    justifyContent: "center",
  },
});

type Task = {
  id: number;
  value: string;
};

function HomeScreen() {
  const [value, setValue] = React.useState("");
  const [tasks, setTasks] = React.useState<Task[]>([]);

  function handleOnPress() {
    if (value) {
      const newTask = {
        id: Math.random(),
        value,
      };
      setTasks((prev) => [...prev, newTask]);
      setValue("");
    }
  }

  return (
    <View style={styles.container}>
      <StatusBar style="auto" />
      {map(
        (item) => (
          <Text key={item.id}>{item.value}</Text>
        ),
        tasks
      )}
      <TextInput
        placeholder="New task"
        onChangeText={(value) => setValue(value)}
        value={value}
      />
      <Button onPress={handleOnPress}>Add a new task</Button>
    </View>
  );
}

export default HomeScreen;
