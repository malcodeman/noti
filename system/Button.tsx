import { Pressable, Text, StyleSheet, PressableProps } from "react-native";

const styles = StyleSheet.create({
  button: {
    padding: 10,
    borderRadius: 10,
    backgroundColor: "#3182ce",
  },
  buttonText: {
    color: "#fff",
    textAlign: "center",
    fontSize: 16,
  },
});

function Button(props: PressableProps) {
  const { children, ...rest } = props;
  return (
    <Pressable {...rest} style={styles.button}>
      <Text style={styles.buttonText}>{children}</Text>
    </Pressable>
  );
}

export default Button;
