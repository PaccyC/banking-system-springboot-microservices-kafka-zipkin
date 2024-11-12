
"use client";

import { Bar, BarChart, CartesianGrid, XAxis, YAxis, ResponsiveContainer } from "recharts";
import { IoIosArrowDown } from "react-icons/io";
import { useLocation } from "react-router-dom";
import {
  Card,
  CardContent,
  CardHeader,
} from "../components/ui/card";
import {
  ChartConfig,
  ChartContainer,
  ChartTooltip,
  ChartTooltipContent,
} from "../components/ui/chart";

const chartDataExpenses = [
  { time: "Jan", desktop: 49, mobile: 240 },
  { time: "Feb", desktop: 305, mobile: 200 },
  { time: "Mar", desktop: 237, mobile: 120 },
  { time: "Apr", desktop: 73, mobile: 190 },
  { time: "May", desktop: 209, mobile: 130 },
  { time: "Jun", desktop: 214, mobile: 140 },
  { time: "Jul", desktop: 214, mobile: 140 },
  { time: "Aug", desktop: 49, mobile: 240 },
  { time: "Sep", desktop: 305, mobile: 200 },
  { time: "Oct", desktop: 237, mobile: 120 },
  { time: "Nov", desktop: 73, mobile: 190 },
  { time: "Dec", desktop: 209, mobile: 130 },
];
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
} satisfies ChartConfig;

export function StatisticsChart() {
  const { pathname } = useLocation();
  return (
    <div className="flex-grow h-full">
      <Card className="border-none h-full"> 
        <CardHeader>
          <div className="flex justify-between w-full items-center">
            <div className="flex gap-2 items-center">
              <h3 className="text-dark-1 font-inter font-semibold text-[16px]">
                {pathname === "/expenses" ? "Monthly Comparison" : "Weekly Comparison"}
              </h3>
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

        <CardContent className="h-full"> 
          <ChartContainer config={chartConfig} className="h-full"> 
            <ResponsiveContainer width="100%" height="100%" aspect={2}> 
              <BarChart data={pathname === "/expenses" ? chartDataExpenses : chartData}>
                <CartesianGrid strokeDasharray="3 3" vertical={false} />
                <XAxis
                  dataKey="time"
                  tickLine={false}
                  tickMargin={10}
                  axisLine={false}
                  tickFormatter={(value) => value.slice(0, 3)}
                />
                <YAxis
                  tickLine={false}
                  tickMargin={10}
                  axisLine={false}
                  tickFormatter={(value) => `$${value}k`}
                  domain={[0, 250]}
                  ticks={[0, 50, 100, 150, 200, 250]}
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
  );
}
