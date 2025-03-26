# 📱 Unit Converter App - SIT708 Task 2.1

[![GitHub Repo](https://img.shields.io/badge/GitHub-Repository-blue?style=flat-square&logo=github)](https://github.com/Tillu6/SIT708--Task-2.1)


This repository contains the Unit Converter Android App developed as part of **Task 2.1 for the unit SIT708 – Mobile Application Development** at Deakin University. The app provides a clean, responsive, and optimized interface for converting between various units of length, weight, and temperature.

---

## ✅ Task Objectives

This project aimed to achieve the following objectives:

1.  Design an intuitive and user-friendly UI for a Unit Converter App.
2.  Implement robust conversion logic for various units of measurement.
3.  Incorporate comprehensive input validation and error handling.
4.  Conduct research on Meta's LLaMA 2 large language model and propose potential integration ideas for mobile applications.

---

## 📱 App Features

Here's a glimpse of the key features implemented in the Unit Converter App:

### 📏 Supported Unit Categories:

* **Length:** inch, foot, yard, cm, km, mile
* **Weight:** pound, ounce, kg, g, ton
* **Temperature:** Celsius (°C), Fahrenheit (°F), Kelvin (K)

### ⚙️ Core Functionalities:

* **Dropdown Menus (Spinners):** Easy selection of source and destination units.
* **Text Input Field:** For entering the numerical value to be converted.
* **Convert Button:** Triggers the conversion process.
* **Result Display Field:** Clearly shows the converted value in the chosen unit.

### ✨ UI Enhancements:

* **Responsive Dark Theme:** A visually appealing and modern dark theme inspired by the Nothing Phone design language.
* **Custom Spinner Layout:** Ensures clear visibility of white text on dark backgrounds for improved readability.
* **Optimized Layout:** Implemented spacing fixes to prevent UI elements from overlapping or appearing cramped.
* **Clean and Minimal Appearance:** Provides a consistent and user-friendly experience across various Android devices.

---

## ✔️ Input Validation & Error Handling

To ensure a smooth and reliable user experience, the following validation and error handling mechanisms are in place:

* **Empty Input Prevention:** Prevents conversion attempts when the input value field is empty.
* **Unit Selection Check:** Displays an informative error message if the user selects the same unit for both the source and destination.
* **Robust Error Handling:** Utilizes `try-catch` blocks and input checks to gracefully handle invalid user inputs and prevent application crashes.

---

## 🔄 Conversion Logic

The app employs a base unit system to ensure accurate and precise conversions between different units.

### ➤ Length Conversions:

* 1 inch = 2.54 cm
* 1 foot = 30.48 cm
* 1 yard = 91.44 cm
* 1 mile = 1.60934 km

### ➤ Weight Conversions:

* 1 pound = 0.453592 kg
* 1 ounce = 28.3495 g
* 1 ton = 907.185 kg

### ➤ Temperature Conversions:

* Celsius to Fahrenheit: `(C * 1.8) + 32`
* Fahrenheit to Celsius: `(F - 32) / 1.8`
* Celsius to Kelvin: `C + 273.15`
* Kelvin to Celsius: `K - 273.15`

---

## 🧠 LLaMA 2 Research Summary

As part of this task, research was conducted on Meta's LLaMA 2, an open-source large language model. The following potential use cases for integrating LLaMA 2 into Android mobile applications were explored:

1.  🤖 **Smart Chatbots:** For automating customer service and providing instant support.
2.  🧠 **AI-Powered Tutors:** Enhancing educational apps with personalized learning assistance.
3.  ✍️ **Content Generation:** Enabling the creation of dynamic text like emails and social media captions.
4.  🔄 **Workflow Automation:** Streamlining repetitive tasks within productivity applications.
5.  📊 **Personalization:** Offering intelligent and real-time suggestions based on user context.

A comprehensive 500-word report detailing the research on LLaMA 2 is included within this repository.

---

## 📸 App Preview

Here are some screenshots showcasing the Unit Converter App's interface:

<p align="center">
  <img src="https://github.com/user-attachments/assets/86b4f61a-d568-42d7-b9bc-c2b3e3b18409" width="234" alt="UI Screenshot 1">
  <img src="https://github.com/user-attachments/assets/533483ee-e625-40e5-a96f-f7dba2583a64" width="234" alt="UI Screenshot 2">
  <img src="https://github.com/user-attachments/assets/0428fbeb-56ce-477d-bf48-2ef5751568ce" width="253" alt="UI Screenshot 3">
</p>

---

## 🙌 Acknowledgements

We would like to express our gratitude to Deakin University for providing the opportunity to explore Android development and delve into emerging technologies like LLaMA 2 through this practical and engaging project.

---
