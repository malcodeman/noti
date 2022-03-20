import React from "react";
import { ScrollView, StyleSheet, Text, View } from "react-native";
import { StatusBar } from "expo-status-bar";
import { map } from "ramda";

import NewTask from "../components/NewTask";

const styles = StyleSheet.create({
  container: {
    paddingTop: 48,
    paddingBottom: 16,
    flexGrow: 1,
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
  const scrollView = React.useRef<ScrollView>(null);

  function handleOnPress(data: { value: string }) {
    if (data.value) {
      const newTask = {
        id: Math.random(),
        value: data.value,
      };
      setTasks((prev) => [...prev, newTask]);
    }
  }

  function handleOnContentSizeChange() {
    scrollView.current?.scrollToEnd({ animated: true });
  }

  return (
    <View style={styles.container}>
      <StatusBar style="auto" />
      <Text style={styles.heading}>My tasks</Text>
      <ScrollView
        ref={scrollView}
        onContentSizeChange={handleOnContentSizeChange}
      >
        {map(
          (item) => (
            <Text key={item.id} style={styles.task}>
              {item.value}
            </Text>
          ),
          tasks
        )}
      </ScrollView>
      <NewTask onSubmit={handleOnPress} />
    </View>
  );
}

export default HomeScreen;
