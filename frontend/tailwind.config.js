/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx}",

  ],
  theme: {
    extend: {
      colors:{
        "secondary":"#F4F5F7",
        "dark-1":"#191919",
        "light-gray":"#E4E7EB",
        "gray-1":"#878787",
        "gray-2":"#4B5768",
        "gray-3":"#999DA3",
        "dark-2":"#525256",
        "primary-1":"#299D91",
        "dark-3":"#4B5768",
        "dark-4":"#191D23",

      },
      fontFamily:{
        "inter":"Inter"
      }
    },
  },
  plugins: [],
}

