import os

def main():
    while True:
        os.system("ant -f offlinebuild.xml")
        os.chdir("build/")
        os.system("java fiuba.algo3.AlgoCraftMain")
        if raw_input("") != "":
            break

if __name__ == "__main__":
    main()
