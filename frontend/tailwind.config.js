/** @type {import('tailwindcss').Config} */
export default {
    darkMode: ["class"],
    content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx}",

  ],
  theme: {
  	extend: {
  		colors: {
  			'secondary': '#F4F5F7',
  			'dark-1': '#191919',
  			'light-gray':'#E4E7EB',
			"light-gray-2":"#F3F3F3",
			"light-gray-3":"hsla(0, 0%, 82%, 0.25)",
			"light-gray-4":"hsla(0, 0%, 63%, 1)",
			"light-gray-5":"hsla(0, 0%, 82%, 1)",
  			'gray-1': '#878787',
  			'gray-2': '#4B5768',
  			'gray-3': '#999DA3',
  			'gray-4': 'hsla(0, 0%, 100%, 0.08)',
  			'gray-5': '#E8E8E8',
			"gray-6":"hsla(0, 0%, 100%, 0.7)",
  			'dark-2': '#525256',
			"dark-3":"#525256",
  			'primary-1': '#299D91',
  			'dark-3': '#4B5768',
  			'dark-4': '#191D23',
			"light-red":"#E73D1C",
  			'dark-white': 'hsla(0, 0%, 100%, 0.7)',
  			background: 'hsl(var(--background))',
  			foreground: 'hsl(var(--foreground))',
  			card: {
  				DEFAULT: 'hsl(var(--card))',
  				foreground: 'hsl(var(--card-foreground))'
  			},
  			popover: {
  				DEFAULT: 'hsl(var(--popover))',
  				foreground: 'hsl(var(--popover-foreground))'
  			},
  			primary: {
  				DEFAULT: 'hsl(var(--primary))',
  				foreground: 'hsl(var(--primary-foreground))'
  			},
  			secondary: {
  				DEFAULT: 'hsl(var(--secondary))',
  				foreground: 'hsl(var(--secondary-foreground))'
  			},
  			muted: {
  				DEFAULT: 'hsl(var(--muted))',
  				foreground: 'hsl(var(--muted-foreground))'
  			},
  			accent: {
  				DEFAULT: 'hsl(var(--accent))',
  				foreground: 'hsl(var(--accent-foreground))'
  			},
  			destructive: {
  				DEFAULT: 'hsl(var(--destructive))',
  				foreground: 'hsl(var(--destructive-foreground))'
  			},
  			border: 'hsl(var(--border))',
  			input: 'hsl(var(--input))',
  			ring: 'hsl(var(--ring))',
  			chart: {
  				'1': 'hsl(var(--chart-1))',
  				'2': 'hsl(var(--chart-2))',
  				'3': 'hsl(var(--chart-3))',
  				'4': 'hsl(var(--chart-4))',
  				'5': 'hsl(var(--chart-5))'
  			}
  		},
  		fontFamily: {
  			'inter': 'Inter'
  		},
  		borderRadius: {
  			lg: 'var(--radius)',
  			md: 'calc(var(--radius) - 2px)',
  			sm: 'calc(var(--radius) - 4px)'
  		}
  	}
  },
  plugins: [require("tailwindcss-animate")],
}

