# MyOCRGemini

MyOCRGemini is a Kotlin Multiplatform application that uses Google's Gemini AI to extract information from Indonesian identification documents. The application currently supports OCR (Optical Character Recognition) for:

- KTP (Kartu Tanda Penduduk / Indonesian ID Card)
- STNK (Surat Tanda Nomor Kendaraan / Indonesian Vehicle Registration)

## Features

- **Cross-platform**: Works on both Android and iOS using Kotlin Multiplatform and Compose Multiplatform
- **Camera Integration**: Built-in camera functionality with flash control
- **Real-time OCR**: Captures images and processes them using Google's Gemini AI
- **Document Framing**: Guides users to position documents correctly within a frame
- **Structured Data Extraction**: Extracts specific fields from documents in a structured format

### KTP (ID Card) Information Extraction

The application extracts the following information from KTP documents:

- Province
- Regency/City
- National Identity Number (NIK)
- Name
- Place and Date of Birth
- Gender
- Address
- RT/RW (Neighborhood/Community identifiers)
- Village/Suburb
- District
- Religion
- Marital Status
- Occupation
- Citizenship

## Technologies Used

- **Kotlin Multiplatform**: For cross-platform code sharing
- **Compose Multiplatform**: For UI development
- **Google Gemini AI**: For OCR and information extraction (using gemini-2.5-flash model)
- **Ktor Client**: For API communication
- **Kotlinx Serialization**: For JSON parsing
- **CameraK**: For camera functionality
- **Koin**: For dependency injection

## Setup

### Prerequisites

- Android Studio Arctic Fox or later
- Xcode 13 or later (for iOS development)
- Google Gemini API Key

### Configuration

1. Clone the repository
2. Add your Google Gemini API key to `composeApp/src/commonMain/composeResources/files/goog_api_key.txt`
3. Build and run the project

## Usage

1. Launch the application
2. Select the document type you want to scan (KTP or STNK)
3. Position the document within the frame shown on the camera screen
4. Ensure the document is clearly visible and all text is readable
5. Tap the capture button to take a photo
6. Wait for the OCR processing to complete
7. View the extracted information

## Project Structure

- `/composeApp`: Contains the shared code for all platforms
  - `commonMain`: Code shared across all platforms
  - `androidMain`: Android-specific code
  - `iosMain`: iOS-specific code
- `/iosApp`: iOS application entry point

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Acknowledgments

- Google Gemini AI for providing the OCR capabilities
- Kotlin Multiplatform for enabling cross-platform development
- Compose Multiplatform for the UI framework