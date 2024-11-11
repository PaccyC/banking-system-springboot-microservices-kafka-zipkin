import { Area, AreaChart, CartesianGrid, XAxis, YAxis} from "recharts";
import { Card, CardContent, CardHeader } from "../components/ui/card";
import { ChartConfig, ChartContainer, ChartTooltip, ChartTooltipContent } from "../components/ui/chart";
import { FiChevronDown } from "react-icons/fi";

const chartData = [
  { time: "May 01", desktop: 600 },
  { time: "May 05", desktop: 2100 },
  { time: "May 10", desktop: 1100 },
  { time: "May 15", desktop: 900 },
  { time: "May 20", desktop: 1600 },
  { time: "May 25", desktop: 3000 },
  { time: "May 30", desktop: 305 }
];

const chartConfig = {
  desktop: {
    label: "Desktop",
    color: "#299D91",
  },
} satisfies ChartConfig;

export function SavingSummaryChart() {
  return (
    <div className="flex-grow h-full">
      <Card>
        <CardHeader>
          <div className="flex justify-between w-full items-center">
            <div className="flex gap-6 items-center">
              <h3 className="text-dark-3 text-2xl font-inter font-bold">Saving Summary</h3>
              <p className="flex gap-2 items-center font-inter font-medium text-[16px] text-dark-2">
                Mar 2022
                <FiChevronDown size={24} className="cursor-pointer" />
              </p>
            </div>
            <div className="flex gap-6 items-center">
              <div className="flex gap-3 items-center">
                <div className="w-4 h-2 bg-primary-1 rounded-[2px]" />
                <p className="font-inter font-medium text-[14px] text-dark-2">This month</p>
              </div>
              <div className="flex gap-3 items-center">
                <div className="w-4 h-2 bg-gray-5 rounded-[2px]" />
                <p className="font-inter font-medium text-[14px] text-dark-2">Same period last month</p>
              </div>
            </div>
          </div>
        </CardHeader>
        <CardContent>
          <ChartContainer config={chartConfig}>
            <AreaChart
              accessibilityLayer
              data={chartData}
              margin={{
                left: 12,
                right: 12,
              }}
            >
              {/* Define the gradient */}
              <defs>
                <linearGradient id="colorDesktop" x1="0" y1="0" x2="0" y2="1">
                  <stop offset="0%" stopColor="#299D91" stopOpacity={0.4} />
                  <stop offset="100%" stopColor="#878787" stopOpacity={0} />
                </linearGradient>
              </defs>

              <CartesianGrid vertical={false} />
              <YAxis
                tickLine={false}
                tickMargin={5}
                accentHeight={5}
                axisLine={false}
                tickFormatter={(value) => `$${value}k`}
                domain={[0, 5000]}
                ticks={[0, 500, 2000, 5000]}
              />
              <XAxis
                dataKey="time"
                tickLine={false}
                axisLine={false}
                tickMargin={8}
                tickFormatter={(value) => value.slice(0, 3)}
              />
              <ChartTooltip
                cursor={false}
                content={<ChartTooltipContent indicator="line" />}
              />
              <Area
                dataKey="desktop"
                type="natural"
                fill="url(#colorDesktop)" // Apply the gradient
                stroke="#299D91"
                fillOpacity={1}
              />
            </AreaChart>
          </ChartContainer>
        </CardContent>
      </Card>
    </div>
  );
}
