file = open("./day_1_elf_calories/input_data.txt", "r")

def find_max_calories(file):
    max_calories = 0
    current_elf_sum = 0
    iterator = iter(file)
    try:
        while True:
            line = next(iterator).rstrip()
            current_elf_sum = current_elf_sum + int(line) if line.isnumeric() else 0
            max_calories = max(max_calories, current_elf_sum)
    except StopIteration:
        return max(max_calories, current_elf_sum)

if __name__ == '__main__':
    print(find_max_calories(file))
