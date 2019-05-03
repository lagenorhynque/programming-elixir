defmodule SentenceCapitalizer do
  def capitalize_sentences(s, separator \\ ". ") do
    s
    |> String.split(separator)
    |> Enum.map(&String.capitalize/1)
    |> Enum.join(separator)
  end
end
