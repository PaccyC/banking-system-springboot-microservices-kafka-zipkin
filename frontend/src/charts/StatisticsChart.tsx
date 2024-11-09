"use client"

import { Bar, BarChart, CartesianGrid, XAxis, ResponsiveContainer } from "recharts"
import { IoIosArrowDown } from "react-icons/io"

import {
  Card,
  CardContent,
  CardHeader,
} from "../components/ui/card"
import {
  ChartConfig,
  ChartContainer,
  ChartTooltip,
  ChartTooltipContent,
} from "../components/ui/chart"

const chartData = [
  { time: "17 Sun", desktop: 49, mobile: 240 },
  { time: "18 Mon", desktop: 305, mobile: 200 },
  { time: "19 Tue", desktop: 237, mobile: 120 },
  { time: "20 Wed", desktop: 73, mobile: 190 },
  { time: "21 Thu", desktop: 209, mobile: 130 },
  { time: "22 Fri", desktop: 214, mobile: 140 },
  { time: "23 Sat", desktop: 214, mobile: 140 },
]

const chartConfig = {
  desktop: {
    label: "Desktop",
    color: "hsla(0, 0%, 91%, 1)",
  },
  mobile: {
    label: "Mobile",
    color: "hsla(174, 59%, 39%, 1)",
  },
} satisfies ChartConfig

export function StatisticsChart() {
  return (
    <div className=" max-h-[70%]">
    <Card className="border-none">
      <CardHeader>
        <div className="flex justify-between w-full items-center">
          <div className="flex gap-2 items-center">
            <h3 className="text-dark-1 font-inter font-semibold text-[16px]">Weekly Comparison</h3>
            <IoIosArrowDown size={20} className="text-dark-2 cursor-pointer" />
          </div>
          <div className="flex gap-6 items-center">
            <div className="flex gap-3 items-center">
              <div className="w-4 h-2 bg-primary-1 rounded-[2px]" />
              <p className="font-inter font-medium text-[14px] text-dark-2">This week</p>
            </div>
            <div className="flex gap-3 items-center">
              <div className="w-4 h-2 bg-gray-5 rounded-[2px]" />
              <p className="font-inter font-medium text-[14px] text-dark-2">Last week</p>
            </div>
          </div>
        </div>
      </CardHeader>

      <CardContent>
        <ChartContainer config={chartConfig}>
          <ResponsiveContainer width="100%" height="100%" className="max-h-[60%] w-full flex flex-grow">
            <BarChart data={chartData}>
              <CartesianGrid vertical={false} />
              <XAxis
                dataKey="time" // Use "time" as the data key
                tickLine={false}
                tickMargin={10}
                axisLine={false}
                tickFormatter={(value) => value.slice(0, 3)} // Format the time to shorten the labels
              />
              <ChartTooltip
                cursor={false}
                content={<ChartTooltipContent indicator="dashed" />}
              />
              <Bar dataKey="desktop" fill="var(--color-desktop)" radius={4} />
              <Bar dataKey="mobile" fill="var(--color-mobile)" radius={4} />
            </BarChart>
          </ResponsiveContainer>
        </ChartContainer>
      </CardContent>
    </Card>
    </div>
  )
}
