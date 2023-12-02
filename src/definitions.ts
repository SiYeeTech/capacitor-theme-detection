export interface ThemeDetectionPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
