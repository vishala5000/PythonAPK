import os

def main():
    print("Python is running inside Android")

    home = os.environ["HOME"]

    output = os.path.join(home, "output.txt")

    with open(output, "w") as f:
        f.write("Python APK working!")

    return output
