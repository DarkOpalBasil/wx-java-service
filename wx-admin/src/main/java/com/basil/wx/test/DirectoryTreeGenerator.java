package com.basil.wx.test;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DirectoryTreeGenerator {

    // 生成目录树主方法
    public static String generate(String rootPath, int maxDepth) throws IOException {
        StringBuilder sb = new StringBuilder();
        Path root = Paths.get(rootPath);
        walkDirectory(root, 0, maxDepth, sb, new ArrayList<>());
        return sb.toString();
    }

    private static void walkDirectory(Path path, int depth, int maxDepth,
                                      StringBuilder sb, List<Boolean> isLastFlags) {
        if (depth > maxDepth) return;

        // 生成缩进符号
        addIndent(sb, depth, isLastFlags);

        // 显示当前节点
        sb.append(path.getFileName()).append("\n");

        if (Files.isDirectory(path)) {
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
                List<Path> children = new ArrayList<>();
                stream.forEach(children::add);
                Collections.sort(children);  // 按名称排序

                for (int i = 0; i < children.size(); i++) {
                    boolean isLast = (i == children.size() - 1);
                    isLastFlags.add(isLast);
                    walkDirectory(children.get(i), depth + 1, maxDepth, sb, isLastFlags);
                    isLastFlags.remove(isLastFlags.size() - 1);
                }
            } catch (IOException e) {
                sb.append(" [访问失败]").append("\n");
            }
        }
    }

    // 添加缩进符号（支持 ASCII 和 Unicode 两种风格）
    private static void addIndent(StringBuilder sb, int depth, List<Boolean> isLastFlags) {
        for (int i = 0; i < depth; i++) {
            if (i >= isLastFlags.size()) break;

            if (isLastFlags.get(i)) {
                sb.append("    ");
            } else {
                sb.append("│   ");  // 或使用 ASCII 的 "|   "
            }
        }

        if (depth > 0) {
            sb.append(isLastFlags.get(depth-1) ? "└── " : "├── ");  // Unicode 符号
            // sb.append(isLastFlags.get(depth-1) ? "`-- " : "|-- ");  // ASCII 符号
        }
    }

    public static void main(String[] args) throws IOException {
        String tree = generate(".", 3);  // 生成当前目录的3层结构
        System.out.println(tree);
    }
}

