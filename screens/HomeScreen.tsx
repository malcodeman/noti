import React from "react";
import { StyleSheet, Text, View } from "react-native";
import { StatusBar } from "expo-status-bar";
import { map } from "ramda";

import NewTask from "../components/NewTask";

const styles = StyleSheet.create({
  container: {
    paddingTop: 48,
    paddingBottom: 16,
  },
  flex: {
    height: "100%",
    display: "flex",
    flexDirection: "column",
    justifyContent: "space-between",
  },
  heading: {
    fontSize: 32,
    paddingHorizontal: 16,
  },
  task: {
    fontSize: 16,
    borderBottomWidth: 1,
    borderBottomColor: "rgba(0,0,0,0.1)",
    padding: 16,
  },
});

type Task = {
  id: number;
  value: string;
};

function HomeScreen() {
  const [tasks, setTasks] = React.useState<Task[]>([]);

  function handleOnPress(data: { value: string }) {
    if (data.value) {
      const newTask = {
        id: Math.random(),
        value: data.value,
      };
      setTasks((prev) => [...prev, newTask]);
    }
  }

  return (
    <View style={styles.container}>
      <StatusBar style="auto" />
      <View style={styles.flex}>
        <View>
          <Text style={styles.heading}>My tasks</Text>
          <View>
            {map(
              (item) => (
                <Text key={item.id} style={styles.task}>
                  {item.value}
                </Text>
              ),
              tasks
            )}
          </View>
        </View>
        <NewTask onSubmit={handleOnPress} />
      </View>
    </View>
  );
}

export default HomeScreen;
