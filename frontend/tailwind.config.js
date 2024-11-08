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
        "gray-4":"hsla(0, 0%, 100%, 0.08)",
        "dark-2":"#525256",
        "primary-1":"#299D91",
        "dark-3":"#4B5768",
        "dark-4":"#191D23",
        "dark-white":"hsla(0, 0%, 100%, 0.7)",


      },
      fontFamily:{
        "inter":"Inter"
      }
    },
  },
  plugins: [],
}

