import os

def main():
    os.system("ant -f offlinebuild.xml")
    os.chdir("build/")
    while True:
        os.system("java fiuba.algo3.AlgoCraftMain")
        if raw_input("") != "":
            break

if __name__ == "__main__":
    main()
