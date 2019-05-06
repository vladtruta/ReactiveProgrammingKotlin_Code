package chapter8

import org.junit.runner.RunWith
import org.junit.runners.Suite

/**
 * Test Suite to run all tests at once (not in the book, but it's a nice way to join tests together)
 */

@RunWith(Suite::class)

@Suite.SuiteClasses(
    TestCalculator::class,
    TestRxKotlin::class,
    TestFunctions::class
)

class TestSuite